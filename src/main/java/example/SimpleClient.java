package example;

import example.grpc.SampleRequest;
import example.grpc.SampleResponse;
import example.grpc.SendServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class SimpleClient {

    private static int count = 0;

    public static void send() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", Main.PORT)
                .usePlaintext()
                .build();

        SampleRequest request = SampleRequest.newBuilder().setId(++count).build();
        SampleResponse response = SendServiceGrpc.newBlockingStub(channel).send(request);

        System.out.println(response.getMessage());
    }

}
