package ravin.com.learnenglish.Home;

/**
 * Created by mayankg on 26/08/16.
 */
public class GridViewInfo {
    private String titile;
    private String imageCode;

    public GridViewInfo(String titile,String imageCode){
        this.titile = titile;
        this.imageCode = imageCode;
    }

    public  String getTitile()  {
        return this.titile;
    }

    public String getImageCode(){
        return this.imageCode;
    }

    public void setTitile(String title){
        this.titile = title;
    }

    public void setImageCode(String imageCode){
        this.imageCode = imageCode;
    }
}
