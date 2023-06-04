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
package PhoneNetworkApp;

import graphFramework.Edge;
import graphFramework.Vertex;


public class Line extends Edge {
    // here i create varible called length 
    private int length;
    
    // here it is the constract methoood 
    public Line(Vertex source, Vertex target, int weight){
        super(source, target, weight);
    }
 
    
}
//end 
