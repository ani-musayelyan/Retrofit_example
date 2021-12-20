package JsonExample

import com.google.gson.annotations.SerializedName

data class Photo (
     var albumId : String? = null ,
     var id : String? = null ,
     var title : String? = null ,
     @SerializedName("url")
     var url : String? = null ,
     var thubnail_url : String? = null
 )