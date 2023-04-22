public class CONTAINER implements Comparable<CONTAINER> {
    private String UUID;
    private String shortNameTag;
     private String longNameTag;


    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getShortNameTag() {
        return shortNameTag;
    }

    public void setShortNameTag(String shortNameTag) {
        this.shortNameTag = shortNameTag;
    }

    public String getLongNameTag() {
        return longNameTag;
    }

    public void setLongNameTag(String longNameTag) {
        this.longNameTag = longNameTag;
    }
    public CONTAINER(){

    }
    @Override
    public String toString(){
       return "<CONTAINER"+ this.getUUID() + ">\n"
       + "<SHORT-NAME>" + this.getShortNameTag() +"</SHORT-NAME>\n"
        + "<LONG-NAME>" + this.getLongNameTag() + "</LONG-NAME>\n" ;
    }


    @Override
    public int compareTo(CONTAINER o) {
        if(this.getShortNameTag().charAt(9) > o.getShortNameTag().charAt(9))
        return 1;
        else if (this.getShortNameTag().charAt(9) < o.getShortNameTag().charAt(9))
            return -1;
        else
            return 0;
    }
}
