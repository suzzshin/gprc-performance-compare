package example;

import example.grpc.SampleRequest;
import example.grpc.SampleResponse;
import example.grpc.SendServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class StreamClient {

    private static int count = 0;

    public static void send() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", Main.PORT_STREAM)
                .usePlaintext()
                .build();

        StreamObserver<SampleRequest> requestObserver = SendServiceGrpc.newStub(channel).sendByStream(new StreamObserver<SampleResponse>() {
            @Override
            public void onNext(SampleResponse value) {
                System.out.println(value.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Completed");
            }
        });

        for (int i = 0; i < Main.LOOP_COUNT; i++) {
            if (i % 10000 == 0) {
                System.out.println("Sent message: " + i);
            }
            SampleRequest request = SampleRequest.newBuilder().setId(++count).build();
            requestObserver.onNext(request);
        }

        requestObserver.onCompleted();
    }

}
