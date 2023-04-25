import java.util.*;

public class Autocomplete {
    private Map<String, Double> weights;

    public Autocomplete(Map<String, Double> weights) {
        this.weights = weights;
    }

    public List<String> getTopK(String prefix, int k) {
        List<String> suggestions = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                double w1 = weights.get(s1);
                double w2 = weights.get(s2);
                return Double.compare(w2, w1);
            }
        });

        for (String str : weights.keySet()) {
            if (str.startsWith(prefix)) {
                pq.offer(str);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        while (!pq.isEmpty()) {
            suggestions.add(0, pq.poll());
        }

        return suggestions;
    }
}
