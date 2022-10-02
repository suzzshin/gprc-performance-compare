package example;

import example.grpc.SendServiceGrpc;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {

    public static final int PORT_SIMPLE = 50051;
    public static final int PORT_STREAM = 50052;

    public static final int LOOP_COUNT = 100000;

    public static final int TIMEOUT_SEC = 10;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("start");
        var now = 0L;

        var simpleServer = ServerBuilder.forPort(PORT_SIMPLE)
                .addService(new SimpleServer())
                .build()
                .start();
        System.out.println("Simple server started, listening on " + PORT_SIMPLE);

        now = System.currentTimeMillis();
        SimpleClient.send();
        System.out.println("Simple client finished in " + (System.currentTimeMillis() - now) + "ms");

        //simpleServer.awaitTermination(TIMEOUT_SEC, TimeUnit.SECONDS);

        var streamServer = ServerBuilder.forPort(PORT_STREAM)
                .addService(new StreamServer())
                .build()
                .start();
        System.out.println("Stream server started, listening on " + PORT_STREAM);

        now = System.currentTimeMillis();
        StreamClient.send();
        System.out.println("Stream client finished in " + (System.currentTimeMillis() - now) + "ms");

        streamServer.awaitTermination(TIMEOUT_SEC, TimeUnit.SECONDS);

        System.out.println("done");
    }

}
