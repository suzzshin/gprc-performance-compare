package example;

import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {

    public static final int PORT = 50051;

    public static void main(String[] args) throws IOException, InterruptedException {
        var server = ServerBuilder.forPort(PORT)
                .addService(new SimpleServer())
                .build()
                .start();

        SimpleClient.send();
        SimpleClient.send();
        SimpleClient.send();

        //server.awaitTermination();
    }
}
