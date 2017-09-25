package com.example.androiddev.digicardx.rest;

import com.example.androiddev.digicardx.main.common.model.RootResponse;
import com.example.androiddev.digicardx.main.common.model.SuccessPojo;
import com.example.androiddev.digicardx.main.login.model.Success;
import com.example.androiddev.digicardx.main.navigation.sms.SmsTemplate;
import com.example.androiddev.digicardx.main.other.model.AddCardPojo;
import com.example.androiddev.digicardx.main.other.model.AppUsedPojo;
import com.example.androiddev.digicardx.main.other.model.CompanySearchPojo;
import com.example.androiddev.digicardx.main.other.model.GetCompaniesPojo;
import com.example.androiddev.digicardx.main.login.model.Otp;
import com.example.androiddev.digicardx.main.other.model.RequestCompanyPojo;
import com.example.androiddev.digicardx.main.home.model.UserCards;
import com.example.androiddev.digicardx.main.login.model.UserLogin;
import com.example.androiddev.digicardx.main.smsSync.SmsSync;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @FormUrlEncoded
    @POST(RestApi.BASE_API_INDEX)
    Call<UserLogin> signUp(@Field("method") String method, @Field("name") String name, @Field("phonenumber") String phonenumber, @Field("devicetype") String devicetype, @Field("devicetoken") String devicetoken);

    @FormUrlEncoded
    @POST(RestApi.BASE_API_INDEX)
    Call<UserLogin> logIn(@Field("method") String method, @Field("login_type") String login_type,@Field("facebookid") String facebookid, @Field("googleid") String googleid, @Field("name") String name, @Field("phone") String phone, @Field("devicetoken") String devicetoken, @Field("devicetype") String devicetype);

    @FormUrlEncoded
    @POST(RestApi.BASE_API_INDEX)
    Call<AddCardPojo> addCards(@Field("method") String method, @Field("card_number") String card_number, @Field("companyid") String companyid, @Field("userid") String userid);

    @FormUrlEncoded
    @POST(RestApi.BASE_API_INDEX)
    Call<CompanySearchPojo> companySearch(@Field("method") String method, @Field("search_keyword") String search_keyword, @Field("userid") String userid,@Field("sessionid") String sessionid);

    @FormUrlEncoded
    @POST(RestApi.BASE_API_INDEX)
    Call<AppUsedPojo> appUsed(@Field("method") String method, @Field("userid") String userid,@Field("sessionid") String sessionid);

    @FormUrlEncoded
    @POST(RestApi.BASE_API_INDEX)
    Call<GetCompaniesPojo> getCompanies(@Field("method") String method);

    @FormUrlEncoded
    @POST(RestApi.BASE_API_INDEX)
    Call<UserCards> getUserCards(@Field("method") String method, @Field("userid") String userid,@Field("sessionid") String sessionid);

    @FormUrlEncoded
    @POST(RestApi.BASE_API_INDEX)
    Call<SuccessPojo> logOut(@Field("method") String method, @Field("userid") String userid,@Field("sessionid") String sessionid);

    @FormUrlEncoded
    @POST(RestApi.BASE_API_INDEX)
    Call<SuccessPojo> CompanySearched(@Field("method") String method, @Field("userid") String userid, @Field("sessionid") String sessionid,@Field("companyid") String companyid, @Field("searched_keyword") String searched_keyword);

    @GET("{phone}/AUTOGEN")
    Call<Otp>  requestOtp(@Path("phone") String phone);

    @GET("{session}/{otp}")
    Call<Otp>  verifyOtp(@Path("session") String session,@Path("otp") String otp);

    @FormUrlEncoded
    @POST(RestApi.BASE_API_INDEX)
    Call<SmsTemplate> getTempates(@Field("method") String method,@Field("userid") String userid,@Field("sessionid") String sessionid);

    @FormUrlEncoded
    @POST(RestApi.BASE_API_INDEX)
    Call<RootResponse> syncData(@Field("method") String method, @Field("userid") String userid, @Field("sessionid") String sessionid, @Field("data") String data, @Field("syncdate") String syncdate);

    @FormUrlEncoded
    @POST(RestApi.BASE_API_INDEX)
    Call<SmsSync> getLastSync(@Field("method") String method,@Field("userid") String userid,@Field("sessionid") String sessionid);

    @FormUrlEncoded
    @POST(RestApi.BASE_API_INDEX)
    Call<SuccessPojo> averageTime(@Field("method") String method, @Field("userid") String userid,@Field("minutes") long minutes,@Field("sessionid") String sessionid);

}
