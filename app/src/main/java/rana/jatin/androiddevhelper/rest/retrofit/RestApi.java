package com.example.androiddev.digicardx.rest;

import com.example.androiddev.digicardx.App;
import com.example.androiddev.digicardx.etc.SharedPreference;
import com.example.androiddev.digicardx.main.common.model.RootResponse;
import com.example.androiddev.digicardx.main.common.model.SuccessPojo;
import com.example.androiddev.digicardx.main.home.model.UserCards;
import com.example.androiddev.digicardx.main.login.model.Success;
import com.example.androiddev.digicardx.main.login.model.UserLogin;
import com.example.androiddev.digicardx.main.navigation.sms.SmsTemplate;
import com.example.androiddev.digicardx.main.other.model.AddCardPojo;
import com.example.androiddev.digicardx.main.other.model.AppUsedPojo;
import com.example.androiddev.digicardx.main.other.model.CompanySearchPojo;
import com.example.androiddev.digicardx.main.other.model.GetCompaniesPojo;
import com.example.androiddev.digicardx.main.other.model.RequestCompanyPojo;
import com.example.androiddev.digicardx.main.smsSync.SmsSync;

import retrofit2.Call;


/**
 * Created by jatin on 7/26/2017.
 */

public class RestApi {
    public static final String SERVER_BASE_URL = "http://techwinlabs.co.in/digicard/api/";
    public static final String BASE_API_INDEX = "index.php";
    public static final String SUCCESS = "Success";
    private static final RestApi ourInstance = new RestApi();
    private String deviceType = "2";
    private ApiService apiService;

    private RestApi() {
        apiService = App.getInstance().getApiService();
    }

    public static RestApi getInstance() {
        return ourInstance;
    }

    /*User up request*/
    public Call<UserLogin> signup(String name, String phonenumber, String deviceToken) {
        return apiService.signUp(Method.SignUp.toString(), name, phonenumber, deviceType, deviceToken);
    }

    /*SocialSign up request*/
    public Call<UserLogin> login(String login_type, String facebookid, String googleid, String name, String phone,String devicetoken) {
        return apiService.logIn(Method.LogIn.toString(), login_type, facebookid, googleid, name, phone,devicetoken, deviceType);
    }

    /*addCards up request*/
    public Call<AddCardPojo> addCards(String card_number, String companyid, String userid) {
        return apiService.addCards(Method.AddCard.toString(), card_number, companyid, userid);
    }

    /*companySearch up request*/
    public Call<CompanySearchPojo> companySearch(String search_keyword, String userid, String sessionId) {
        return apiService.companySearch(Method.CompanySearch.toString(), search_keyword, userid, sessionId);
    }

    /*appused up request*/
    public Call<AppUsedPojo> appUsed(String userid, String sessionId) {
        return apiService.appUsed(Method.AppUsed.toString(), userid, sessionId);
    }

    /*getallcompanies up request*/
    public Call<GetCompaniesPojo> getCompanies() {
        return apiService.getCompanies(Method.GetCompanies.toString());
    }

    /*getUserCard up request*/
    public Call<UserCards> usercards(String userid, String sessionId) {
        return apiService.getUserCards(Method.UserCards.toString(), userid, sessionId);
    }

    /*companySearched up request*/
    public Call<SuccessPojo> companySearched(String userid, String sessionId, String companyid, String searched_keyword) {
        return apiService.CompanySearched(Method.CompanySearched.toString(), userid, sessionId, companyid, searched_keyword);
    }

    public Call<SuccessPojo> logOut(String userid, String sessionId) {
        return apiService.logOut(Method.LogOut.toString(), userid, sessionId);
    }

    public Call<SmsTemplate> getTempates() {
        return apiService.getTempates(Method.GetTempates.toString(),SharedPreference.getInstance().getUserId(),SharedPreference.getInstance().getSessionId());
    }

    public Call<RootResponse> syncData(String userid, String sessionId, String data, String syncdate) {
        return apiService.syncData(Method.SyncData.toString(), userid, sessionId,data,syncdate);
    }

    public Call<SmsSync> getLastSync() {
        return apiService.getLastSync(Method.GetLastSync.toString(), SharedPreference.getInstance().getUserId(),SharedPreference.getInstance().getSessionId());
    }

    public Call<SuccessPojo> averageTime(String userid,long time, String sessionId) {
        return apiService.averageTime(Method.AverageTime.toString(), userid,time,  sessionId);
    }

    private enum Method {
        LogIn,
        SignUp,
        CompanySearch,
        AddCard,
        AppUsed,
        GetCompanies,
        UserCards,
        LogOut,
        CompanySearched,
        GetTempates,
        SyncData,
        GetLastSync,
        AverageTime
    }
}
