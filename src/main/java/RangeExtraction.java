import java.util.ArrayList;
import java.util.List;

/**
 * A format for expressing an ordered list of integers is to use a comma separated list of either
 * <p>
 * <li>individual integers</li>
 * <li>or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'. The range includes all integers in the interval including both endpoints. It is not considered a range unless it spans at least 3 numbers. For example "12,13,15-17"</li>
 * <p>
 * <p>Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted string in the range format.
 */


public class RangeExtraction {
    public static String rangeExtraction(int[] arr) {
        List<Integer> range = new ArrayList<>();
        StringBuilder result = new StringBuilder();


        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] == arr[i - 1] + 1) {
                range.add(arr[i]);
                continue;
            }

            result = appendToResult(range, result);
            range.clear();
            range.add(arr[i]);

        }
        if (!range.isEmpty()) result = appendToResult(range, result);

        return result.toString();
    }

    private static StringBuilder appendToResult(List<Integer> range, StringBuilder res) {
        if (!res.isEmpty()) {
            res.append(",");
        }

        if (range.size() >= 3) {
            res.append(range.get(0)).append("-").append(range.get(range.size() - 1));

        } else {
            for (int i = 0; i < range.size(); i++) {
                res.append(range.get(i));
                if (i < range.size() - 1) res.append(",");
            }
        }


        return res;
    }

}
