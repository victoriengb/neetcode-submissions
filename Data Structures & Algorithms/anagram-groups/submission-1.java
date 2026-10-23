class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0){
            List<String> listWithEmptyString = new ArrayList<String>();
            listWithEmptyString.add("");
            
            List<List<String>> groupedAnagrams = new ArrayList<List<String>>();
            groupedAnagrams.add(listWithEmptyString);
            return groupedAnagrams;
        }
        if (strs.length == 1){
            List<String> listWithSingleString = new ArrayList<String>();
            listWithSingleString.add(strs[0]);
            
            List<List<String>> groupedAnagrams = new ArrayList<List<String>>();
            groupedAnagrams.add(listWithSingleString);
            return groupedAnagrams;
        }

        HashMap<Integer, List<String>> mapHashToAnagrams = new HashMap<>();
        for (int i = 0 ; i < strs.length ; i++){
            List<String> groupedAnagrams = mapHashToAnagrams.putIfAbsent(wordToCharacterFrequency(strs[i]).hashCode(), new ArrayList<String>());

            if (groupedAnagrams != null)
                groupedAnagrams.add(strs[i]);
            else{
                    mapHashToAnagrams.get(wordToCharacterFrequency(strs[i]).hashCode()).add(strs[i]);
            }
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for (Integer hash : mapHashToAnagrams.keySet()){
            result.add(mapHashToAnagrams.get(hash));
        }
        return result;
    }

    private List<Integer> wordToCharacterFrequency(String word){
        List<Integer> listOfFrequencies = new ArrayList<>();
        for (int i = 0 ; i < 26 ; i++){
            listOfFrequencies.add(0);
        }
        for (int i = 0 ; i < word.length() ; i++){
            int index = word.charAt(i) - 97;
            listOfFrequencies.set(index, listOfFrequencies.get(index) + 1);
        }
        return listOfFrequencies;
    }
}
