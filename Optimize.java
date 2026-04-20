import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Optimize {
    public static void main(String[] args) {

        int min = Integer.MAX_VALUE;
        int count = 0;
        ArrayList<String> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("mydata.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int a = 0; a <= 4; a++)
            for (int b = 0; b <= 4; b++)
                for (int c = 0; c <= 4; c++)
                    for (int d = 0; d <= 4; d++)
                        for (int e = 0; e <= 4; e++)
                            for (int f = 0; f <= 4; f++)
                                for (int g = 0; g <= 4; g++)
                                    for (int h = 0; h <= 4; h++)
                                        for (int i = 0; i <= 4; i++) {
                                            int[] weights = { a, b, c, d, e, f, g, h, i };
                                            LPHashTable table = new LPHashTable(37);
                                            table.setWeights(weights);

                                            for (String student : data) {
                                                table.insert(student);
                                            }

                                            if (table.getProbeCount() < min) {
                                                min = table.getProbeCount();
                                                count = 1;
                                            } else if (table.getProbeCount() == min) {
                                                count++;
                                            }
                                        }
        System.out.println(min + " " + count);
    }
}
