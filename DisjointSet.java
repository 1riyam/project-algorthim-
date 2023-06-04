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

public class DisjointSet {
    // here i create to var parent and rank 
    private DisjointSet parent;
    private int rank;
    //here i craete a DisjointSet methood 
    public DisjointSet(Vertex vertex) {
        this.parent = this;
        this.rank = 0;
    }
   //here i craete a find methood 
    public DisjointSet find() {
        if (this.parent != this) {
            this.parent = this.parent.find();
        }
        return this.parent;
    }
    // here i craete a uniuon methood 
    public void union(DisjointSet other) {
        DisjointSet root1 = this.find();
        DisjointSet root2 = other.find();
       // here i crrate an if statment to check if root 1 equal to root 2
        if (root1 == root2) {
            return;
        }
        // here i crate an if statment to see if if root 1 less than root2
        if (root1.rank < root2.rank) {
            root1.parent = root2;
        } else if (root1.rank > root2.rank) {
            root2.parent = root1;
        } else {
            root2.parent = root1;
            root1.rank++;
        }
    }
}
//end 