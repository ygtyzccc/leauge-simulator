package util;

import java.util.Random;

public class RandomUtil {
    public static int [] toRandomDifIntArray(int min, int maks, int n)
    {
        Random r = new Random();
        int [] numbers = new int[n];

        for(int i = 0; i < n; ++i) {
            int k;
            do{
                numbers[i] = r.nextInt(maks - min) + min;
                for(k = 0; k < n; ++k)
                    if (numbers[i] == numbers[k])
                        break;

            } while (k < i);
        }

        return numbers;
    }
}
