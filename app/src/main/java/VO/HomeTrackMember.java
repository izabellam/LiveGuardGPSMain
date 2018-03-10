package VO;

/**
 * Created by amirlubashevsky on 08/03/2018.
 */

public class HomeTrackMember {

    private String mName;
    private String mAge;
    private String mPhone;
    private String mImageUrl;
    private double mLatitude;
    private double mLongitude;
    private String mDescription;
    private String mGender;
    private String pushId; // unique id for HomeTrackMember, for changes or deleting from db

    public HomeTrackMember(){}

    public HomeTrackMember(  String name,
            String phone,
            String imageUrl,
            String description
            ){
        setmName(name);
        setmPhone(phone);
        setmImageUrl(imageUrl);
        setmDescription(description);
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public double getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(double mLatitude) {
        this.mLatitude = mLatitude;
    }

    public double getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(double mLongitude) {
        this.mLongitude = mLongitude;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmAge() {
        return mAge;
    }

    public void setmAge(String mAge) {
        this.mAge = mAge;
    }

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }
}
