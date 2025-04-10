package ru.mygraphes;

import static ru.mygraphes.Main.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class ScreenMenu implements Screen {
    Main main;

    public SpriteBatch batch;
    public OrthographicCamera camera;
    public Vector3 touch;
    public BitmapFont font;

    Texture imgBG;

    GraphesButton btnGraphes;
    GraphesButton btnAbout;
    GraphesButton btnExit;

    public ScreenMenu(Main main) {
        this.main = main;
        batch = main.batch;
        camera = main.camera;
        touch = main.touch;
        font = main.font;

        imgBG = new Texture("Mainmain.jpg");

        btnGraphes = new GraphesButton(font, "Graphes", 250, 1000);
        btnAbout = new GraphesButton(font, "About", 250, 700);
        btnExit = new GraphesButton(font, "Exit", 250, 400);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //касания
        if(Gdx.input.justTouched()) {
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);

            if(btnGraphes.hit(touch.x, touch.y)) {
                main.setScreen(main.screenGraphes);
            }
            if(btnAbout.hit(touch.x, touch.y)) {
                main.setScreen(main.screenAbout);
            }
            if(btnExit.hit(touch.x, touch.y)) {
                Gdx.app.exit();
            }
        }

        //отрисовка
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        font.draw(batch, "Menu", 350, 1300);
        btnGraphes.font.draw(batch, btnGraphes.text, btnGraphes.x, btnGraphes.y);
        btnAbout.font.draw(batch, btnAbout.text, btnAbout.x, btnAbout.y);
        btnExit.font.draw(batch, btnExit.text, btnExit.x, btnExit.y);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        imgBG.dispose();
    }
}
