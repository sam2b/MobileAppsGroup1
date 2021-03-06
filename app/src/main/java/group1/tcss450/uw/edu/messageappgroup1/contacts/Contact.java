package group1.tcss450.uw.edu.messageappgroup1.contacts;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Contact implements Serializable {
    private final String mFirstName;
    private final String mLastName;
    private final String mNickName;
    private final String mEmail;
    private final String mTopic;
    private final int mChatID;
    private final int mID;
    public boolean hasNewMessage = false;

    /**
     * Helper class to build the contact.
     * @author Kevin Nguyen
     */
    public static class Builder {
        private String mFirstName = "";
        private String mLastName = "";
        private String mNickName = "";
        private String mEmail = "";
        private String mTopic = "";
        private int mChatID = 0;
        private int    mID = -1;

        public Builder() {
            // Do nothing
        }

        public Builder addFirstName(final String val) {
            mFirstName = val;
            return this;
        }

        public Builder addLastName(final String val) {
            mLastName = val;
            return this;
        }

        public Builder addNickName(final String val) {
            mNickName = val;
            return this;
        }

        public Builder addID(final int val) {
            mID = val;
            return this;
        }

        public Builder addEmail(final String val) {
            mEmail = val;
            return this;
        }

        public Builder addTopic(final String val) {
            mTopic = val;
            return this;
        }

        public Builder addChatID(final int val) {
            mChatID = val;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }

    private Contact(final Builder builder) {
        this.mFirstName = builder.mFirstName;
        this.mLastName = builder.mLastName;
        this.mNickName = builder.mNickName;
        this.mEmail = builder.mEmail;
        this.mTopic = builder.mTopic;
        this.mChatID = builder.mChatID;
        this.mID = builder.mID;
    }

    public String getFirstName() {
        return this.mFirstName;
    }

    public String getLastName() {
        return this.mLastName;
    }

    public String getNickName() {
        return this.mNickName;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public int getChatID() {return this.mChatID;}

    public int getID() {
        return this.mID;
    }

    public String getTopic() {
        return mTopic;
    }

    /**
     * Get all of the fields in a single JSON object. Note, if no values were provided for the
     * optional fields via the Builder, the JSON object will include the empty string for those
     * fields.
     *
     * Keys: memberID, firstname, lastname, nickname.
     *
     * @return all of the fields in a single JSON object
     */
    public JSONObject asJSONObject() {
        //build the JSONObject
        JSONObject msg = new JSONObject();
        try {
            msg.put("memberID", getID());
            msg.put("firstname", getFirstName());
            msg.put("lastname", getLastName());
            msg.put("nickname", getNickName());
            msg.put("topicname", getTopic());
            msg.put("chatid", getChatID());
            msg.put("email", getEmail());
        } catch (JSONException e) {
            Log.wtf("Contact", "Error creating JSON: " + e.getMessage());
        }
        return msg;
    }

    public void setHasNewMessage(boolean has) {
        hasNewMessage = has;
    }
}
