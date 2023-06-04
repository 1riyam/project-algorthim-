/*
Group Members: 
2006847 Lujain Abdulaziz AlSulami
2005517 Asal Ali Alghamdi
2006739 Ryam Abdulwase Alsahafie 
2106125 Laura Ismail Fatta

References:
GeeksforGeeks. (2023b). Applications of Minimum Spanning Tree Problem. GeeksforGeeks. https://www.geeksforgeeks.org/applications-of-minimum-spanning-tree/

Poe - Fast, Helpful AI Chat. (n.d.). https://poe.com/

https://www.gatevidyalay.com/tag/kruskals-algorithm-example-with-solution/

Instructor :
I. أسماء الشنقيطي 
I. سيدرا قريشي

*/
package graphFramework;

import java.io.FileNotFoundException;
import PhoneNetworkApp.Office;
import PhoneNetworkApp.Line;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.Map;
import java.io.File;


public class Graph {
    // here i crate an offive and line list 
    private List<Office> vertices;
    private List<Line> edges;
    int verticesNo;
    int edgesNo;
    private Office source;
    private Office target;

    public void readGraphFromFile(String filename) {
        // here i start to cratea a map 
        Map<String, Office> vertexMap = new HashMap<>();

        try {
            File ffile = new File(filename);
            Scanner scanner = new Scanner(ffile);
            
            // here is a string of type graph 
            String digraph = scanner.nextLine();
            
            if(digraph.equalsIgnoreCase("digraph 0")){
                System.out.println("\n                Indirect graph              \n");
            }else{
                 System.out.println("\n                direct graph              \n");
            }

            
            // array of type string 
            String[] countss = scanner.nextLine().split(" ");
            int numVertices = Integer.parseInt(countss[0]);
            int numEdges = Integer.parseInt(countss[1]);
            

            // Create edges
            for (int i = 0; i < numEdges; i++) {
                countss = scanner.nextLine().split(" ");
                String sourceLabel = countss[0];
                String targetLabel = countss[1];
                int weight = Integer.parseInt(countss[2]);

                Office thesourceVertex = vertexMap.get(sourceLabel);
                Office thetargetVertex = vertexMap.get(targetLabel);

                if (thesourceVertex == null) {
                    thesourceVertex = new Office(sourceLabel);
                    vertexMap.put(sourceLabel, thesourceVertex);
                    addVertex(thesourceVertex);
                }

                if (thetargetVertex == null) {
                    thetargetVertex = new Office(targetLabel);
                    vertexMap.put(targetLabel, thetargetVertex);
                    addVertex(thetargetVertex);
                }

                Line edge = new Line(thesourceVertex, thetargetVertex, weight);
                addEdge(edge);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }       
    }
    
   // constarte methood 
    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }
    // here is the setSource methood 
    public void setSource(Office source) {
        this.source = source;
    }
    // here is the getSource methood 
    public Office getSource() {
        return source;
    }
    // here is the setTarget methood 
    public void setTarget(Office target) {
        this.target = target;
    }
    // here is the getTarget methood 
    public Office getTarget() {
        return target;
    }
    // here is the add vertex methood 
    public void addVertex(Office vertex) {
        this.vertices.add(vertex);
    }
    // here is the add edage methood 
    public void addEdge(Line edge) {
        edges.add(edge);
        this.edges.add(edge);
        this.vertices.add((Office) edge.getSource());
        this.vertices.add((Office) edge.getTarget());
    }
    // here is the getVertices methood 
    public List<Office> getVertices() {
        return this.vertices;
    }
    // here is the getEdges methood 
    public List<Line> getEdges() {
        return this.edges;
    }
     // here is the hasEdge  methood 
    public boolean hasEdge(Office source, Office target) {
        for (Line edge : edges) {
            if (edge.getSource().equals(source) && edge.getTarget().equals(target)) {
                return true;
            }
        }
        return false;
    }
        // here is the getEdgesFromVertex  methood 
        public List<Edge> getEdgesFromVertex(Vertex vertex) {
        List<Edge> edges = new ArrayList<>();
        for (Edge edge : this.edges) {
            if (edge.getSource().equals(vertex) || edge.getTarget().equals(vertex)) {
                edges.add(edge);
            }
        }
        return edges;
    }
    // here is the generateRandomGraph  methood 
    public static Graph generateRandomGraph(int vertexsCount, int edgeCount) {
        Graph graph = new Graph();
        Random random_r = new Random();
       // here is the i crate a for loop 
        for (int i = 1; i <= vertexsCount; i++) {
            Office vertex = new Office(Integer.toString(i));
            graph.addVertex(vertex);
        }
        // here i crate a list of name vertices
        List<Office> vertices = graph.getVertices();
        int rcount = 0;

        while (rcount < edgeCount) {
            int sourceIndex = random_r.nextInt(vertexsCount);
            int targetIndex = random_r.nextInt(vertexsCount);
            Office thesource = vertices.get(sourceIndex);
            Office thetarget = vertices.get(targetIndex);
            // here i crate an if stament to check if thesource != thetarget && !graph.hasEdge(thesource, thetarget
            if (thesource != thetarget && !graph.hasEdge(thesource, thetarget)) {
            // genrate a Random weight from 1 to 100
            int weight = random_r.nextInt(100) + 1; 
            // here i crate a var name edgesr of type string 
            Line edgesr = new Line(thesource, thetarget, weight);
            graph.addEdge(edgesr);
            rcount++;
            }
        }

        return graph;
    }
}
