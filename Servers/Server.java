package Servers;

import Nodes.Node;
import Optional.Optional;

import java.util.ArrayList;

public class Server {


    private ArrayList<Optional<Node>> nodeList = new ArrayList<>();
    private int serverNumber;


    public Server(int serverNumber) {
        if (serverNumber >= 0) {
            this.serverNumber = serverNumber;
        }
    }

    public void setServerNumber(int serverNumber) {
        if (serverNumber >= 0) {
            this.serverNumber = serverNumber;
        }
    }

    public int getServerNumber() {
        return serverNumber;
    }

    public ArrayList<Optional<Node>> getNodeList() {
        return nodeList;
    }

    public void setNodeList(int nodeNumber) {
        if (nodeNumber > 0) {
            nodeList.add(new Optional<Node>(new Node(nodeNumber)));
        }
    }

    public void createNode(int nodeListCapacity, int nodeNumber) {

        if (nodeListCapacity > 0 && nodeNumber >= 0) {
            for (int i = 0; i < nodeListCapacity; i++) {
                setNodeList(nodeNumber + i);
            }
        }

    }
}
