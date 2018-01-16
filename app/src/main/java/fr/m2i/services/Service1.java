package fr.m2i.services;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import java.io.FileOutputStream;

import static fr.m2i.services.Tools.showNotification;

public class Service1 extends Service {
    public Service1() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        showNotification(this, "Démarrage du service !");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        showNotification(this, "Arrêt du service !");
    }


    public int onStartCommand(Intent intent, int flags, int startId) {
        showNotification(this, "Début du traitement !");

        try {
            FileOutputStream stream = openFileOutput("data", MODE_PRIVATE);
            for (Integer i = 0; i < 1000000; i++) {
                stream.write(i.toString().getBytes());
            }
            stream.close();
            stopSelf(); // Arrêter le service
        } catch (Exception ex) {
            showNotification(this, "ERREUR arrêt du service !");
        }
        showNotification(this, "Arret du traitement !");
        return super.onStartCommand(intent, flags, startId);
    }


}
