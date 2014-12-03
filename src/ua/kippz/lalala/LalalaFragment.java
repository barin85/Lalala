package ua.kippz.lalala;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class LalalaFragment extends Fragment {

	private ImageButton mPlayButton;
	private ImageButton mStopButton;
	AudioPlayer mPlayer = new AudioPlayer();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_lalala, parent, false);
		mPlayButton = (ImageButton) v.findViewById(R.id.imageButton_play);
		mPlayButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Log.e("LalalaFragment","mPlayButton");
				mPlayer.play(getActivity());
			}
		});

		mStopButton = (ImageButton) v.findViewById(R.id.imageButton_pause);
		mStopButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mPlayer.stop();
			}
		});


		return v;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();
	}



}
