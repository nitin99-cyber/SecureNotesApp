
public class Note {
    int sr;
    String Title;   String Content;
    Note(int sr, String Title, String Content){                 // Constructor Class
        this.sr =sr;    this.Title =Title;  this.Content=Content;
    }
    public String getTitle() {
        return Title;

    }
    public String getContent() {
        return Content;
    }
}

