class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        PriorityQueue<Integer> allocator = new PriorityQueue<>((a,b) -> a - b);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // Sorted by start time

        allocator.add(intervals[0][1]);
        for(int i = 1; i<intervals.length; i++){
            if(!allocator.isEmpty() && intervals[i][0] >= allocator.peek()){
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }

        return allocator.size();
    }
}
