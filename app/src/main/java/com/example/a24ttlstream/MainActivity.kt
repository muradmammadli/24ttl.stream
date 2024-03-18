package com.example.a24ttlstream

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a24ttlstream.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Test.loadHtmlContent(binding.webView,"\n" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "  <link rel=\"shortcut icon\" href=\"./favicon.ico\" type=\"image/x-icon\">\n" +
                "  <title>AR Demo || 24Stream</title>\n" +
                "  <link href=\"./index.css\" rel=\"stylesheet\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\">\n" +
                "  <div class=\"exampleWrapperContent\"></div>\n" +
                "  <div class=\"error-container\">\n" +
                "    <img src=\"./images/error.svg\" alt=\"error\">\n" +
                "    <h1 class=\"title\">Что-то пошло<br/> не так</h1>\n" +
                "    <div class=\"btn\" onclick=\"window.close();\">Вернуться в магазин</div>\n" +
                "    <div class=\"credits\">Powered by 24TTL</div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "<script>(function (w, d, s, o) {\n" +
                "  var f = d.getElementsByTagName(s)[0];\n" +
                "  var j = d.createElement(s);\n" +
                "  w.TTLStreamReady = new Promise((resolve) => {\n" +
                "    j.async = true;\n" +
                "    j.src = 'https://content.24ttl.stream/widget.js';\n" +
                "    f.parentNode.insertBefore(j, f);\n" +
                "    j.onload = function () {\n" +
                "      w.ttlStream = new TTLStream(o);\n" +
                "      resolve(w.ttlStream);\n" +
                "    };\n" +
                "  });\n" +
                "})(window, document, 'script', {});\n" +
                "</script>\n" +
                "<script>\n" +
                "  try {\n" +
                "    TTLStreamReady.then(() => {\n" +
                "\n" +
                "      var URLquery = window.location.search.split(\"?\");\n" +
                "      var URL = URLquery[1].split(\"&\");\n" +
                "      var productID = {productId}" +
                "      var retailerDomain = {retailerDomain};" +
                "      var brand = {brand};" +
                "      var fallbackURL = document.referrer;\n" +
                "\n" +
                "      for (var index = 0; index < URL.length; index++) {\n" +
                "        var splitBy = URL[index].split(\"=\");\n" +
                "        switch (splitBy[0]) {\n" +
                "          case \"product_id\":\n" +
                "            productID = splitBy[1];\n" +
                "            break;\n" +
                "          case \"retailer_domain\":\n" +
                "            retailerDomain = splitBy[1];\n" +
                "            break;\n" +
                "          case \"brand\":\n" +
                "            brand = splitBy[1];\n" +
                "            break;\n" +
                "          case \"fallback_url\":\n" +
                "            fallbackURL = splitBy[1];\n" +
                "            break;\n" +
                "        }\n" +
                "      }\n" +
                "\n" +
                "      ttlStream.setArSettings({\n" +
                "        \"preview\": {\n" +
                "          \"fallbackURL\": fallbackURL,\n" +
                "          \"autoShow\": true,\n" +
                "          \"html\": \"Посмотреть в интерьере\",\n" +
                "          \"style\": {},\n" +
                "          \"previewBtnClose\": {\n" +
                "            \"useHistoryBack\": true,\n" +
                "          },\n" +
                "        },\n" +
                "        \"mobilePreview\": {\n" +
                "          \"fallbackURL\": fallbackURL,\n" +
                "          \"autoShow\": true,\n" +
                "          \"html\": \"Посмотреть в интерьере\",\n" +
                "          \"style\": {},\n" +
                "          \"previewBtnClose\": {\n" +
                "            \"useHistoryBack\": true,\n" +
                "          },\n" +
                "        },\n" +
                "        \"viewer\": {\n" +
                "          \"fallbackURL\": fallbackURL,\n" +
                "          \"modalStyle\": {\n" +
                "            \"borderColor\": \"#fff\",\n" +
                "            \"outline\": \"none\",\n" +
                "            \"display\": \"block\",\n" +
                "          },\n" +
                "          \"viewerStyle\": {\n" +
                "            \"width\": \"100%\",\n" +
                "            \"height\": \"100%\",\n" +
                "            \"borderColor\": \"#fff\",\n" +
                "            \"background-color\": \"#fff\",\n" +
                "          },\n" +
                "          \"loaderColor\": \"#000000\",\n" +
                "          \"closeStyle\": {\n" +
                "            \"display\": \"none\",\n" +
                "          },\n" +
                "          \"previewBtnClose\": {\n" +
                "            \"useHistoryBack\": true,\n" +
                "          },\n" +
                "        },\n" +
                "        \"qr\": {\n" +
                "          \"modal\": { \"style\": {} },\n" +
                "          \"box\": { \"style\": {}, },\n" +
                "          \"fallbackURL\": document.referrer,\n" +
                "          \"btnOpen\": {\n" +
                "            \"html\": \"Посмотреть в интерьере\",\n" +
                "            \"style\": {\n" +
                "              \"bottom\": \"40px\",\n" +
                "            }\n" +
                "          },\n" +
                "          \"btnClose\": {\n" +
                "            \"useHistoryBack\": true,\n" +
                "          },\n" +
                "        }\n" +
                "      });\n" +
                "\n" +
                "      ttlStream.findAndInsert({\n" +
                "        \"brand\": brand,\n" +
                "        \"productId\": productID,\n" +
                "        \"retailerDomain\": retailerDomain,\n" +
                "        \"templateType\": \"\",\n" +
                "        \"resultType\": \"html\",\n" +
                "        \"contentType\": \"ar\",\n" +
                "        \"el\": \".exampleWrapperContent\"\n" +
                "      }).catch(function (e) {\n" +
                "        console.error(e.message);\n" +
                "        document.querySelector(\".exampleWrapperContent\").style.display = \"none\";\n" +
                "        document.querySelector(\".error-container\").style.display = \"flex\";\n" +
                "      });\n" +
                "    }).catch(function (e) {\n" +
                "      console.error(e.message);\n" +
                "      document.querySelector(\".exampleWrapperContent\").style.display = \"none\";\n" +
                "      document.querySelector(\".error-container\").style.display = \"flex\";\n" +
                "    });\n" +
                "  } catch (e) {\n" +
                "    console.error(e.message);\n" +
                "    document.querySelector(\".exampleWrapperContent\").style.display = \"none\";\n" +
                "    document.querySelector(\".error-container\").style.display = \"flex\";\n" +
                "  }\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>\n".replaceFirst("{productId}","2"))
    }
}