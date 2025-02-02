// Time: O(n)
// Space: O(1)


class Solution{
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0, maxCount = 0;

        // calculate maxFrequency
        for (char task : tasks) {
            if (!map.containsKey(task)) {
                map.put(task, 0);
            }
            int cnt = map.get(task);
            cnt++;
            maxFreq = Math.max(maxFreq, cnt);
            map.put(task, cnt);
        }
        // if more than 1 task have freq = maxFreq -
        for (char task : map.keySet()) {
            if (map.get(task) == maxFreq) {
                maxCount++;
            }
        }
        // formulas -
        int partitions = maxFreq - 1;
        int available = partitions * (n - (maxCount - 1));
        int pending = tasks.length - (maxFreq * maxCount);
        int empty = Math.max(0, available - pending);

        return tasks.length + empty;
    }
}