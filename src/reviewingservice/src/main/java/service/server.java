package service;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class server {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server runnable = ServerBuilder.forPort(9090).addService(new ReviewService()).build();
        runnable.start();
        System.out.println("Server started " + runnable.getPort());
        runnable.awaitTermination();
    }
}
