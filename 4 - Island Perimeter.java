//day 4
//iterative
class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid.length==0 || grid==null) return 0;
        int ans=0;
        for( int i=0;i<grid.length;i++){
            for( int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                ans+=checksides(i, j, grid);            
            }
        }
        return ans;
    }
    int checksides(int i, int j, int[][]grid){
        int c=4;
        if(i>0 && grid[i-1][j]==1) c--;
        if(j>0 && grid[i][j-1]==1) c--;
        if(i<grid.length-1 && grid[i+1][j]==1) c--;
        if(j<grid[0].length-1 && grid[i][j+1]==1) c--;
        return c;
    }
}