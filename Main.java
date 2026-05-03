import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // --- 1. PARAMETRELER ---
        final long studentNo = 1240505044L;
        final int n = 100000;              // Veri boyutu
        final int k = 150;                 // Monte Carlo iterasyonu
        final int testRuns = 100;           
        final int specialCondition = 777;   

        Random rand = new Random(studentNo);

        // --- 2. VERI SETINI OLUSTURMA ---
        int[] data = new int[n];
        int actualSpecialCount = 0;

        for (int i = 0; i < n; i++) {
            data[i] = rand.nextInt(1000000); 
            if (data[i] % specialCondition == 0) {
                actualSpecialCount++;
            }
        }

        double p = (double) actualSpecialCount / n; 

        // --- 3. DENEYI CALISTIRMA ---
        int successCount = 0;
        double totalExecutionTime = 0;
        double[] executionTimes = new double[testRuns];

        for (int i = 0; i < testRuns; i++) {
            long currentSeed = studentNo + i;
            
            long startTime = System.nanoTime();
            boolean found = runMonteCarlo(data, k, specialCondition, currentSeed);
            long endTime = System.nanoTime();

            if (found) successCount++;
            
            double duration = (endTime - startTime) / 1000000.0;
            executionTimes[i] = duration;
            totalExecutionTime += duration;
        }

        // --- 4. ISTATISTIKLER ---
        double actualErrorRate = 1.0 - ((double) successCount / testRuns);
        double theoreticalErrorRate = Math.pow((1.0 - p), k);
        double avgTime = totalExecutionTime / testRuns;

        double sumSqDiff = 0;
        for (double t : executionTimes) {
            sumSqDiff += Math.pow(t - avgTime, 2);
        }
        double stdDevTime = Math.sqrt(sumSqDiff / testRuns);

        // --- 5. SONUCLAR ---
        System.out.println("==========================================");
        System.out.println("Veri Boyutu (n): " + n);
        System.out.println("Ozel Eleman Sayisi: " + actualSpecialCount + " (p: " + p + ")");
        System.out.println("Monte Carlo Iterasyon (k): " + k);
        System.out.println("==========================================");
        System.out.printf("Teorik Hata Olasiligi: %.5f\n", theoreticalErrorRate);
        System.out.printf("Deneysel Hata Orani:   %.5f\n", actualErrorRate);
        System.out.printf("Ortalama Sure:         %.6f ms\n", avgTime);
        System.out.printf("Zaman St. Sapmasi:     %.6f ms\n", stdDevTime);
        System.out.println("==========================================");
    }

    public static boolean runMonteCarlo(int[] dataset, int k, int condition, long seed) {
        Random r = new Random(seed);
        int length = dataset.length;
        for (int i = 0; i < k; i++) {
            if (dataset[r.nextInt(length)] % condition == 0) {
                return true; 
            }
        }
        return false; 
    }
}