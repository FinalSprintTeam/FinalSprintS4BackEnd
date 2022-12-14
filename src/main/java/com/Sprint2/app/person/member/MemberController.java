package com.Sprint2.app.person.member;

import com.Sprint2.app.person.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://semester4-sprint2-website.s3-website-us-east-1.amazonaws.com/", "http://localhost:3000/"})
public class MemberController {
    @Autowired MemberService memberService;

    @GetMapping(path = "api/member/all")
    public List<Member> getMembers(){
        return memberService.getMembers();
    }

    @GetMapping(path = "api/member")
    public Member findByEmail(@RequestParam String email){
        return memberService.getMemberByEmail(email);
    }

    @GetMapping(path = "api/member/{id}")
    public Member findById(@PathVariable("id") Long id){
        return memberService.getMemberById(id);
    }

    @PostMapping(path = "api/member/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Member> registerMember(@RequestBody Member member, @RequestParam Long addressID, @RequestParam String typeName){
        return new ResponseEntity<>(memberService.addMember(member, addressID, typeName), HttpStatus.OK);
    }

    @PutMapping(path = "api/member/{id}/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Member> updateMember(@RequestBody Member member, @RequestParam Long addressID, @RequestParam String typeName) {
        return new ResponseEntity<>(memberService.editMember(member, addressID, typeName), HttpStatus.OK);
    }

    @DeleteMapping(path = "api/member/{id}/delete")
    public void deleteMember(@PathVariable("id") Long memberId){
        memberService.deleteTournament(memberId);
    }
}
