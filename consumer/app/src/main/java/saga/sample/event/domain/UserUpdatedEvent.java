package saga.sample.event.domain;

import saga.sample.model.User;

public class UserUpdatedEvent implements Event {
    private User user;

    public UserUpdatedEvent() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
