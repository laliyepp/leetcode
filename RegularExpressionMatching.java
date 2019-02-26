class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] bool2DArray = new boolean[s.length()+1][p.length()+1];
        bool2DArray[s.length()][p.length()] = true;
        
        for (int i=s.length();i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                boolean firstMatch = (i<s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
                if (j+1 < p.length() && p.charAt(j+1) == '*'){
                    bool2DArray[i][j] = bool2DArray[i][j+2] || (firstMatch && bool2DArray[i+1][j]);
                } else{
                    bool2DArray[i][j] = firstMatch && bool2DArray[i+1][j+1];
                }
            }
        }
        
        return bool2DArray[0][0];
    }
}