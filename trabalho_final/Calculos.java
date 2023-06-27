package trabalho_final;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculos {
    public static void main(String[] args) {
        List<Object> valores = new ArrayList<>();
        valores.add(0.0);
        valores.add(5.0);
        valores.add(2.5);
        valores.add(2.5);

       //for (int i = 0; i < ListaDeValores.size(); i++) {
          //valores.add(listaDeValores.get(i));
       //}

        boolean contemFloats = contemFloats(valores);
        boolean contemInteiros = contemInteiros(valores);
        boolean contemStrings = contemStrings(valores);

        if (contemFloats && !contemInteiros && !contemStrings) {
            List<Float> floats = converterParaFloats(valores);
            analyzeNumericData(floats);
        } else if (contemInteiros && !contemFloats && !contemStrings) {
            List<Integer> inteiros = converterParaInteiros(valores);
            analyzeIntegerData(inteiros);
        } else if (contemStrings && !contemFloats && !contemInteiros) {
            List<String> strings = converterParaStrings(valores);
            analyzeStringData(strings);
        } else {
            System.out.println("A lista contém uma combinação inválida de tipos de dados.");
        }
    }

    private static boolean contemFloats(List<Object> valores) {
        for (Object valor : valores) {
            if (valor instanceof Float || valor instanceof Double) {
                return true;
            }
        }
        return false;
    }

    private static List<Float> converterParaFloats(List<Object> valores) {
        List<Float> floats = new ArrayList<>();
        for (Object valor : valores) {
            if (valor instanceof Integer) {
                floats.add(((Integer) valor).floatValue());
            } else if (valor instanceof Float) {
                floats.add((Float) valor);
            } else if (valor instanceof Double) {
                floats.add(((Double) valor).floatValue());
            }
        }
        return floats;
    }

    private static boolean contemInteiros(List<Object> valores) {
        for (Object valor : valores) {
            if (valor instanceof Integer) {
                return true;
            }
        }
        return false;
    }

    private static List<Integer> converterParaInteiros(List<Object> valores) {
        List<Integer> inteiros = new ArrayList<>();
        for (Object valor : valores) {
            inteiros.add((Integer) valor);
        }
        return inteiros;
    }

    private static boolean contemStrings(List<Object> valores) {
        for (Object valor : valores) {
            if (valor instanceof String) {
                return true;
            }
        }
        return false;
    }

    private static List<String> converterParaStrings(List<Object> valores) {
        List<String> strings = new ArrayList<>();
        for (Object valor : valores) {
            strings.add((String) valor);
        }
        return strings;
    }

    private static void analyzeNumericData(List<Float> numericData) {
        int n = numericData.size();
        float sum = 0;
        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;

        Map<Float, Integer> frequencies = new HashMap<>();
        int maxFrequency = 0;

        for (float value : numericData) {
            sum += value;

            if (value > max) {
                max = value;
            }

            if (value < min) {
                min = value;
            }

            int frequency = frequencies.getOrDefault(value, 0) + 1;
            frequencies.put(value, frequency);

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        float media = sum / n;
        float variance = calculateVariance(numericData, media);
        float standardDeviation = (float) Math.sqrt(variance);
        List<Float> moda = findModa(frequencies, maxFrequency);

        int k = (int) Math.ceil(1 + 3.222 * Math.log(n));
        float At = max - min;
        float h = (float) Math.ceil(At / k);

        System.out.println("\nHistograma:\n");
        drawHistogram(frequencies, min, max, k, h);

        System.out.println("\nMédia: " + media);
        System.out.println("Moda: " + moda);
        System.out.println("Variância: " + variance);
        System.out.println("Desvio Padrão: " + standardDeviation);
        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
    }

    private static void analyzeIntegerData(List<Integer> numericData) {
        int n = numericData.size();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int value : numericData) {
            sum += value;

            if (value > max) {
                max = value;
            }

            if (value < min) {
                min = value;
            }
        }

        double media = (double) sum / n;
        double variance = calculateVariance(numericData, media);
        double standardDeviation = Math.sqrt(variance);
      
        Map<Integer, Integer> frequencies = new HashMap<>();
        int maxFrequency = 0;
        int moda = 0;

        for (int value : numericData) {
            int frequency = frequencies.getOrDefault(value, 0) + 1;
            frequencies.put(value, frequency);

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                moda = value;
            }
        }

        System.out.println("\nGráfico de Colunas:\n");
        drawColumnChart(frequencies);

        System.out.println("\nMédia: " + media);
        System.out.println("Moda: " + moda);
        System.out.println("Variância: " + variance);
        System.out.println("Desvio Padrão: " + standardDeviation);
        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
    }

    private static void analyzeStringData(List<String> stringData) {
        Map<String, Integer> frequencies = new HashMap<>();
        int maxFrequency = 0;

        for (String value : stringData) {
            int frequency = frequencies.getOrDefault(value, 0) + 1;
            frequencies.put(value, frequency);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        System.out.println("\nGráfico de Colunas:\n");
        drawColumnChart(frequencies);

       List<String> moda = findModaStrings(stringData);
       System.out.println("\nModa: " + moda);
    }

    private static void drawColumnChart(Map<?, Integer> frequencies) {
        for (Map.Entry<?, Integer> entry : frequencies.entrySet()) {
            String value = entry.getKey().toString();
            int frequency = entry.getValue();

            System.out.printf("%s: ", value);
            for (int i = 0; i < frequency; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void drawHistogram(Map<?, Integer> frequencies, float min, float max, int k, float h) {
        System.out.println("k = " + k);
        System.out.println("h = " + h);
        System.out.println("\nIntervalos:");

        float lowerBound = (float) Math.floor(min);
        float upperBound = lowerBound + h;

        for (int i = 0; i < k; i++) {
            int frequency = frequenciesInRange(frequencies, lowerBound, upperBound);

            System.out.printf("[%.2f, %.2f): ", lowerBound, upperBound);
            for (int j = 0; j < frequency; j++) {
                System.out.print("*");
            }
            System.out.println();

            lowerBound = upperBound;
            upperBound += h;
        }
    }

    private static int frequenciesInRange(Map<?, Integer> frequencies, float lowerBound, float upperBound) {
        int frequency = 0;
        for (Map.Entry<?, Integer> entry : frequencies.entrySet()) {
            float value = Float.parseFloat(entry.getKey().toString());
            if (value >= lowerBound && value < upperBound) {
                frequency += entry.getValue();
            }
        }
        return frequency;
    }

    private static float calculateVariance(List<Float> numericData, float media) {
        float sum = 0;
        for (float value : numericData) {
            sum += Math.pow(value - media, 2);
        }
        return sum / numericData.size();
    }

    private static double calculateVariance(List<Integer> numericData, double media) {
        double sum = 0;
        for (int value : numericData) {
            sum += Math.pow(value - media, 2);
        }
        return sum / numericData.size();
    }

    private static List<Float> findModa(Map<?, Integer> frequencies, int maxFrequency) {
        List<Float> moda = new ArrayList<>();
        for (Map.Entry<?, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                moda.add(Float.parseFloat(entry.getKey().toString()));
            }
        }
        return moda;
    }
  
    private static List<String> findModaStrings(List<String> stringData) {
      Map<String, Integer> frequencies = new HashMap<>();
      int maxFrequency = 0;
  
      for (String value : stringData) {
          int frequency = frequencies.getOrDefault(value, 0) + 1;
          frequencies.put(value, frequency);
  
          if (frequency > maxFrequency) {
              maxFrequency = frequency;
          }
      }
  
      List<String> moda = new ArrayList<>();
      for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
          if (entry.getValue() == maxFrequency) {
              moda.add(entry.getKey());
          }
      }
  
      return moda;
  }

}