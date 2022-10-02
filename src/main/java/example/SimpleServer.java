package example;

import example.grpc.SendServiceGrpc;
import example.grpc.SampleRequest;
import example.grpc.SampleResponse;
import io.grpc.stub.StreamObserver;

public class SimpleServer extends SendServiceGrpc.SendServiceImplBase {

    private int count = 0;

    @Override
    public void send(SampleRequest request, StreamObserver<SampleResponse> responseObserver) {
        if (request.getId() % 10000 == 0) {
            System.out.println("Received message: " + request.getId());
        }

        SampleResponse response = SampleResponse.newBuilder().setMessage(++count).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
