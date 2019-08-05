package cehs0703.seo.travel.ListVO;

public class Tab2ItemVO {
    String ImgUrl;
    String Title;
    String Desc;

    public Tab2ItemVO(String imgUrl, String title, String desc) {
        ImgUrl = imgUrl;
        Title = title;
        Desc = desc;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
