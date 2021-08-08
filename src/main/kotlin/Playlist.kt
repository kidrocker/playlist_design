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
     *  @param track Track
     */
    override fun addTrack(track: Track) {
        if(getNumberOfTracks() < limit) {
            mTrack.add(track)
        }
        else throw Exception("Maximum number of tracks exceeded")
    }

    /**
     * Add multiple tracks to list
     * @param tracks List<Track>
     */
    override fun addTracks(tracks: List<Track>) {
        val totalEstimate = getNumberOfTracks() + tracks.size
        if(totalEstimate <= limit) mTrack.addAll(tracks)
        else throw Exception("Maximum number of tracks exceeded")
    }

    /**
     * Delete single track from the list
     * @param track Track
     */
    override fun deleteTrack(track: Track) {
        mTrack.remove(track)
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