package com.fm.app.fm.getplayersbyresource;

import java.io.IOException;

public final class App {
    private App()
    {
    }

    public static void main(String[] args)
    {
        try {
            GetPlayersFromFile getPlayersFromFile =
                    new GetPlayersFromFile("C:/Users/ASUS/Desktop/Teams/Fenerbahce.txt");

            getPlayersFromFile.run();
            getPlayersFromFile.displaySquad();
        }

        catch (IOException ignore)
        {
            System.err.println("Dosya islemlerinde bir hata olustu");
        }


    }
}
