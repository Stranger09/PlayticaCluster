package FailSearchEngine;

import Cluster.Cluster;

public class FailSearchEngine {

    Cluster search;

    public FailSearchEngine(Cluster search) {
        this.search = search;
    }

    public void search() {

        System.out.println("Searching the fail Nodes.Node");
        System.out.println();
        try {
            Thread.sleep(500);
        }
        catch (Exception e){}

        for (int i = 0; i < search.getServers().size(); i++) {
            int mid = search.getServers().get(i).get().getNodeList().size() / 2;

            if (search.isFailed(i, mid)) {
                for (int j = mid; j >= 0; j--) {
                    if (!search.isFailed(i, j)) {
                        System.out.println("Failed Servers.Server is " + search.getServers().get(i).get().getServerNumber());
                        System.out.println("Failed Nodes.Node is " + search.getServers().get(i).get().getNodeList().get(j + 1).get().getNodeNumber());
                        return;
                    } else if (search.isFailed(i, 0)) {
                        System.out.println("Failed Servers.Server is " + search.getServers().get(i).get().getServerNumber());
                        System.out.println("Failed Nodes.Node is " + search.getServers().get(i).get().getNodeList().get(0).get().getNodeNumber());
                        return;
                    }

                }
            } else if (!search.isFailed(i, mid)) {
                for (int j = mid; j < search.getServers().get(i).get().getNodeList().size(); j++) {
                    if (search.isFailed(i, j)) {
                        System.out.println("Failed Servers.Server is " + search.getServers().get(i).get().getServerNumber());
                        System.out.println("Failed Nodes.Node is " + search.getServers().get(i).get().getNodeList().get(j).get().getNodeNumber());
                        return;
                    }
                }
            }

        }
    }
}









