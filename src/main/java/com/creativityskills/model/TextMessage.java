package com.creativityskills.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "tbl_messages")
@NamedQueries({
        @NamedQuery(
                name = "GET_ALL_MESSAGES",
                query = "SELECT m FROM TextMessage m"
        )
}

)
public class TextMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "message")
    private String body;
    @Column(name = "sender")
    private String recipient;
    @Column(name = "receiver")
    private String sender;
    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    Date created_time;

    @Column(name = "sent_status")
    @Enumerated(EnumType.STRING)
    private MessageStatus sentStatus;

    public TextMessage() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public MessageStatus getSentStatus() {
        return sentStatus;
    }

    public void setSentStatus(MessageStatus sentStatus) {
        this.sentStatus = sentStatus;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", recipient='" + recipient + '\'' +
                ", sender='" + sender + '\'' +
                ", created_time=" + created_time +
                ", sentStatus=" + sentStatus +
                '}';
    }
}
