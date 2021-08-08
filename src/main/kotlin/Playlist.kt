import interfaces.ITrack
import models.Track
import models.User

class Playlist(private val user: User): ITrack {

    private val mTrack = mutableSetOf<Track>()

    private var limit: Int = when(user.isPro){
        true -> 200
        false -> 100
    }

    /**
     * Add a new track to the playlist
     */
    override fun addTrack(track: Track) {
        if(getNumberOfTracks() < limit) {
            mTrack.add(track)
        }
        else throw Exception("Maximum number of tracks exceeded")
    }

    override fun addTracks(tracks: List<Track>) {
        TODO("Not yet implemented")
    }

    override fun deleteTrack(track: Track) {
        TODO("Not yet implemented")
    }

    override fun deleteTracks(tracks: List<Track>) {
        TODO("Not yet implemented")
    }

    override fun getTotalDuration(): Long {
        TODO("Not yet implemented")
    }

    override fun getNumberOfTracks(): Int {
        TODO("Not yet implemented")
    }

    override fun getTrack(id:Int): Track {
        TODO("Not yet implemented")
    }

    override fun getAllTracks(): List<Track> {
        TODO("Not yet implemented")
    }
}