package com.fm.app.fm.menu;

import java.util.Scanner;

public class MenuApp {
    private static final Scanner KB = new Scanner(System.in);

    public static void displayOptions()
    {
        System.out.println("1.Ligdeki takimlari goster");
        System.out.println("2.Ev sahibi takimi sec");
        System.out.println("3.Deplasman takimi sec");

    }

    public void chooseOption(int i)
    {

    }

    public int getOption()
    {
        System.out.print("Option:");

        return Integer.parseInt(KB.nextLine());
    }


}
