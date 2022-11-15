/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum.formktm;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Isa Jaisyullah
 */

@Controller
public class myController {
    @RequestMapping("/view")
    public String tampil(
            @RequestParam(value = "nama") String nama,
            @RequestParam(value = "nim") String nim,
            @RequestParam(value = "prodi") String prodi,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "img") MultipartFile gambar,
            Model model    
    ) throws IOException{
        String bImage = Base64.encodeBase64String(gambar.getBytes());
        String image = "data:image/*;base64, ".concat(bImage);    
        
        model.addAttribute("nam", nama);
        model.addAttribute("nim", nim);
        model.addAttribute("prod", prodi);
        model.addAttribute("em", email);
        model.addAttribute("gam", image);   
        
        return "view";
    }
    
}
