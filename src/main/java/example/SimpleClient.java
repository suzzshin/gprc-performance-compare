package example;

import example.grpc.SampleRequest;
import example.grpc.SampleResponse;
import example.grpc.SendServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class SimpleClient {

    private static int count = 0;

    public static void send() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", Main.PORT_SIMPLE)
                .usePlaintext()
                .build();

        for (int i = 0; i < Main.LOOP_COUNT; i++) {
            if (i % 10000 == 0) {
                System.out.println("Sent message: " + i);
            }
            SampleRequest request = SampleRequest.newBuilder().setId(++count).build();
            SampleResponse response = SendServiceGrpc.newBlockingStub(channel).send(request);
            //System.out.println(response.getMessage());
        }
    }

}
