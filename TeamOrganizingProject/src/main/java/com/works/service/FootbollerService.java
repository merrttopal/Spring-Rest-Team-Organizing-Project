package com.works.service;

import com.works.configs.Standard;
import com.works.entities.Footbollers;
import com.works.repositories.FootbollersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class FootbollerService {
    final HttpServletRequest request;
    final HttpServletResponse response;
    final FootbollersRepository repository;
    final TinkEncDec tinkEncDec;

    public ResponseEntity save (Footbollers footbollers){
        try {
            footbollers.setPassword(tinkEncDec.encrypt(footbollers.getPassword()));
            repository.save(footbollers);
            Standard standard = new Standard(true, footbollers);
            return new ResponseEntity(standard, HttpStatus.OK);
        }catch (Exception exception){
            Standard standard = new Standard(false,exception.getMessage());
            return new ResponseEntity(standard,HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity login (String email, String password){
        try {

            // veritabanından email ile eşleşen bir Footbollers nesnesi bul
            Footbollers footbollers = repository.findByEmail(email);


            if (footbollers == null) {
                Standard standard = new Standard(false,"Email not found");
                return new ResponseEntity(standard,HttpStatus.BAD_REQUEST);
            }

            // bulunan Footbollers nesnesinin şifresini google tink ile deşifre et
            String decryptedPassword = tinkEncDec.decrypt(footbollers.getPassword());

            // deşifre edilen şifreyi giriş yapan kullanıcının şifresi ile karşılaştır
            if (decryptedPassword.equals(password)) {

                Standard standard = new Standard(true, footbollers);
                Cookie cookie = new Cookie("footbollers", ""+ footbollers.getFid());
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);
                request.getSession().setAttribute("footbollers", footbollers);
                request.getSession().setAttribute("fid", footbollers.getFid());
                return new ResponseEntity(standard, HttpStatus.OK);
            } else {
                Standard standard = new Standard(false,"Wrong password");
                return new ResponseEntity(standard,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception exception){

            Standard standard = new Standard(false,exception.getMessage());
            return new ResponseEntity(standard,HttpStatus.BAD_REQUEST);
        }
    }





}
