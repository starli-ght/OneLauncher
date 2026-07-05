package com.onelauncher;

// ==============================
// Category Template
// ==============================

// ==============================
// Library Imports 
// ==============================
import com.google.gson.Gson;

// ==============================
// File Imports..?
// ==============================
import com.onelauncher.model.Manifest;

public class Launcher {

    public void start() {

        Downloader downloader = new Downloader();
        Gson gson = new Gson();

        System.out.println("Initializing launcher...");

        try {
        
            String json = downloader.get(
                "https://piston-meta.mojang.com/mc/game/version_manifest_v2.json"
            );
            
            Manifest manifest = gson.fromJson(json, Manifest.class);
            
            System.out.println(manifest.latest.release);
        
        }
        catch (Exception e) {
        
            e.printStackTrace();
        
        }

        System.out.println("Done!");

    }

    public void printVersion() {
        System.out.println("Launcher Version: " + Config.LAUNCHER_VERSION);
    }

}