package com.example.springproj3;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
@Service
public class ArchitectureService {


    public static String saveArchitecture(Architecture architecture) throws ExecutionException, InterruptedException {

        Firestore databaseFirestore = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture = databaseFirestore.collection("architectures").document(architecture.name).set(architecture);

        return collectionApiFuture.get().getUpdateTime().toString();

    }

    public static Architecture getArchitectureInfo(String name) throws ExecutionException, InterruptedException {

        Firestore databaseFirestore = FirestoreClient.getFirestore();

        DocumentReference documentReference = databaseFirestore.collection("architectures").document(name);

        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Architecture architecture;

        if (document.exists()) {

            architecture = document.toObject(Architecture.class);

            return architecture;

        } else {

            return null;

        }
    }
}