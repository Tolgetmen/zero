/******************************************************************************
 * Copyright 2016 Fabian Lupa                                                 *
 ******************************************************************************/

package com.flaiker.zero.box2d;

import com.badlogic.gdx.physics.box2d.*;

/**
 * Listener class for interaction between to Box2D objects. Add an instance of {@link ContactCallback} as the userdata
 * of an Box2D object to receive an event on contact.
 */
public class WorldContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        if (fa.getUserData() instanceof ContactCallback) {
            ((ContactCallback) fa.getUserData()).onContactStart();
        }

        if (fb.getUserData() instanceof ContactCallback) {
            ((ContactCallback) fb.getUserData()).onContactStart();
        }

        if (fa.getUserData() instanceof AdvancedContactCallback) {
            ((AdvancedContactCallback) fa.getUserData()).onContactStart(fb.getBody());
        }

        if (fb.getUserData() instanceof AdvancedContactCallback) {
            ((AdvancedContactCallback) fb.getUserData()).onContactStart(fa.getBody());
        }

    }

    @Override
    public void endContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        if (fa.getUserData() instanceof ContactCallback) {
            ((ContactCallback) fa.getUserData()).onContactStop();
        }

        if (fb.getUserData() instanceof ContactCallback) {
            ((ContactCallback) fb.getUserData()).onContactStop();
        }

        if (fa.getUserData() instanceof AdvancedContactCallback) {
            ((AdvancedContactCallback) fa.getUserData()).onContactStop(fb.getBody());
        }

        if (fb.getUserData() instanceof AdvancedContactCallback) {
            ((AdvancedContactCallback) fb.getUserData()).onContactStop(fa.getBody());
        }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
