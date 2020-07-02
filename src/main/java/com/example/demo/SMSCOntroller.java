package com.example.demo;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Say;
import com.twilio.twiml.voice.Say.Language;
import com.twilio.type.PhoneNumber;

@RestController
public class SMSCOntroller {
	
	@PostMapping(value="voice",produces =MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> getMessage() {
	String message = "I love you";
	Say say = new Say.Builder("hi monika, you have a new message " + message).voice(Say.Voice.WOMAN).language(Language.EN_US).build();
	VoiceResponse vs = new VoiceResponse.Builder().say(say).build();
	return new ResponseEntity<>(vs.toXml(),HttpStatus.CREATED);
	}
	
}
