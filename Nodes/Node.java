package Nodes;

public class Node {

    private int nodeNumber;
    private boolean isFailed;
    private boolean isPresent;


    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        this.isPresent = present;
    }

    public Node(int nodeNumber){
        this.nodeNumber = nodeNumber;
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(int nodeNumber) {
        if(nodeNumber > 0) {
            this.nodeNumber = nodeNumber;
        }
    }

    public void setFailed(boolean failed) {
        isFailed = failed;
    }

    public boolean getIsFailed() {
        return isFailed;
    }
}