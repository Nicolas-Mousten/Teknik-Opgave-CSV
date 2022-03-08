public class ImdbData {
    private int Year;
    private int Length;
    private String Title;
    private String Subject;
    private int Popularity;
    private String Awards;

    public ImdbData(int year, int length, String title, String subject, int popularity, String awards) {
        Year = year;
        Length = length;
        Title = title;
        Subject = subject;
        Popularity = popularity;
        Awards = awards;
    }

    public int getYear() {
        return Year;
    }

    public int getLength() {
        return Length;
    }

    public String getTitle() {
        return Title;
    }

    public String getSubject() {
        return Subject;
    }

    public int getPopularity() {
        return Popularity;
    }

    public String getAwards() {
        return Awards;
    }

    @Override
    public String toString() {
        return "ImdbData{" +
                "Year=" + Year +
                ", Length=" + Length +
                ", Title='" + Title + '\'' +
                ", Subject='" + Subject + '\'' +
                ", Popularity=" + Popularity +
                ", Awards=" + Awards +
                '}';
    }
}
