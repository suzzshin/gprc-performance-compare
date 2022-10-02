package example;

import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {

    public static final int PORT = 50051;

    public static void main(String[] args) throws IOException, InterruptedException {
        var server = ServerBuilder.forPort(PORT)
                .addService(new Server())
                .build()
                .start();

        Client.send();
        Client.send();
        Client.send();

        //server.awaitTermination();
    }
}
