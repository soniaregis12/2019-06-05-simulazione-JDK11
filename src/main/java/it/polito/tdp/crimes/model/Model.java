package it.polito.tdp.crimes.model;

import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.crimes.db.EventsDao;

public class Model {
	
	private EventsDao dao;
	private SimpleGraph<Integer, DefaultEdge> grafo;
	
	public Model() {
		this.dao = new EventsDao();
	}
	
	public List<Integer> getAllYears(){
		return this.dao.getAllYears();
	}
	
	public void creaGrafo(int anno) {
		
		this.grafo = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
		
		List<Integer> vertici = this.dao.getVertici();
		for(Integer v : vertici) {
			this.grafo.addVertex(v);
		}
		
		
		List<Distretto> distretti = this.dao.getDIstrettiLongLat(anno);
		
		for(Distretto d1 : distretti) {
			for(Distretto d2 : distretti) {
				if(!d1.equals(d2)) {
					DefaultEdge e = this.grafo.getEdge(d1.getDistretto(), d2.getDistretto());
					double distanza = 0.0;
					if(e == null) {
						System.out.println(d1.getPunto());
						System.out.println(d2.getPunto());
						distanza = LatLngTool.distance(d1.getPunto(), d2.getPunto(), LengthUnit.KILOMETER);
						System.out.println(d1.getDistretto().toString());
						System.out.println(d2.getDistretto().toString());
						System.out.println(distanza);
						Graphs.addEdgeWithVertices(this.grafo, d1.getDistretto(), d2.getDistretto(), distanza);
					}
					
				}
			}
		}
	}

	public SimpleGraph<Integer, DefaultEdge> getGrafo() {
		return grafo;
	}
	
	
}
