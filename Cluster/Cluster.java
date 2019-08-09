package Cluster;

import FailSearchEngine.FailSearchEngine;
import Optional.Optional;
import Servers.Server;

import java.util.ArrayList;

public class Cluster {

    public static void main(String[] args) {

        Cluster cluster = new Cluster();
        FailSearchEngine failSearch = new FailSearchEngine(cluster);

        cluster.createServer(4, cluster.getServers().size()+1);

        //create nodes
        for(int i = 0; i < cluster.getServers().size(); i++) {
            int nodeNumber = cluster.getServers().get(i).get().getNodeList().size() + 1;
            int randCapacity = (int)  (Math.random()*10) +1 ;
            cluster.getServers().get(i).get().createNode(randCapacity, nodeNumber);
        }

        cluster.sendMessage();
        failSearch.search();

    }


    private ArrayList <Optional<Server>> servers = new ArrayList<>();



    public ArrayList<Optional<Server>> getServers() {
        return servers;
    }

    public void setServers(int serverNumber){
        if(serverNumber>0) {
            servers.add(new Optional<Server>(new Server(serverNumber)));
        }
    }

    public void createServer(int serverCapacity, int serverNumber){
        if(serverCapacity>0 && serverNumber>=0) {
            for (int i = 0; i < serverCapacity; i++) {
                setServers(serverNumber + i);
            }
        }

    }

    public void sendMessage(){
        int randServer = (int) (Math.random()*getServers().size());
        int randNode = (int) (Math.random()*getServers().get(randServer).get().getNodeList().size());

        getServers().get(randServer).get().getNodeList().get(randNode).get().setFailed(true);

        System.out.println("System is hacking now...");
        System.out.println("Please wait some seconds");
        for (int i = 3; i > 0; i--) {
            try {
                System.out.println(i);
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }

        for (int i = 0; i < getServers().size(); i++){
            for (int j = 1; j < getServers().get(i).get().getNodeList().size(); j++){
                if (getServers().get(i).get().getNodeList().get(j-1).get().getIsFailed()){
                    getServers().get(i).get().getNodeList().get(j).get().setFailed(true);
                    if(getServers().get(i).get().getServerNumber() == getServers().size()){
                        getServers().get(i).get().getNodeList().get(0).get().setFailed(true);
                    }
                    else getServers().get(i+1).get().getNodeList().get(0).get().setFailed(true);
                }
            }
        }
        System.out.println("System is already hacked ;)");
    }

    public boolean isFailed(int serverNumber, int nodeNumber) {

        if (!getServers().get(serverNumber).get().getNodeList().get(nodeNumber).get().getIsFailed()) {
            return false;
        }
        else {
            return true;
        }
    }



}



